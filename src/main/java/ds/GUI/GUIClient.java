package ds.GUI;

import ds.alertservice.Alert;
import ds.alertservice.AlertConfirmation;
import ds.alertservice.AlertServiceGrpc;
import ds.pollutionanalysisservice.*;
import ds.pollutionsensorservice.*;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: GUIClient
 * Description:
 *
 * @Author: Jiaxin Zhang
 * @Creat: 11/04/2023 17:26
 * @Version: 1.8
 */
public class GUIClient implements ActionListener{
    private static JmDNS jmdns;
    private JTextField entry1, reply1;
    private JTextField entry2, entry5,entry6, entry7, entry8, entry9;
    private JTextArea reply2, reply3, reply4, reply5, reply6, reply8;
    private JTextField entry3;
    private JTextField entry4;
    List<String> locations = new ArrayList<>();
    List<String> broadcastLocations = new ArrayList<>();
    List<String> broadcastMessage = new ArrayList<>();
    private ServiceInfo PollutionSensorServiceInfo;


    private final CountDownLatch latch = new CountDownLatch(1);


    //    private static PollutionSensorServiceGrpc.PollutionSensorServiceStub asyncStub;

    private List<ServiceInfo> serviceInfos = new ArrayList<>();

    public static class MyServiceListener implements ServiceListener {

        @Override
        public void serviceAdded(ServiceEvent event) {
            System.out.println("Service added: " + event.getInfo());
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service removed: " + event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            System.out.println("Service resolved: " + event.getInfo());
        }

    }

//    public GUIClient() {
//        discoverAndRegisterService("_pollution-sensor._tcp.local.", 50051);
//        discoverAndRegisterService("_pollution-analysis._tcp.local.", 50052);
//        discoverAndRegisterService("_alert-service._tcp.local.", 50053);
//    }

//    private void discoverAndRegisterService(String serviceType, int port) {
//        try {
//            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
//            jmdns.addServiceListener(serviceType, new MyServiceListener());
//            ServiceInfo[] infos = jmdns.list(serviceType);
//            if (infos.length > 0) {
//                ServiceInfo info = infos[0];
////                info.(port);
//                jmdns.registerService(info);
//                serviceInfos.add(info);
//            }
//            jmdns.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    try {
//        // Create a JmDNS instance
//        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
//
//        jmdns.addServiceListener(service_type, new ServiceListener() {
//
//            @Override
//            public void serviceResolved(ServiceEvent event) {
//                System.out.println("Pollution Sensor Service resolved: " + event.getInfo());
//
//                PollutionSensorServiceInfo = event.getInfo();
//
//                int port = PollutionSensorServiceInfo.getPort();
//
//                System.out.println("resolving " + service_type + " with properties ...");
//                System.out.println("\t port: " + port);
//                System.out.println("\t type:"+ event.getType());
//                System.out.println("\t name: " + event.getName());
//                System.out.println("\t description/properties: " + PollutionSensorServiceInfo.getNiceTextString());
//                System.out.println("\t host: " + PollutionSensorServiceInfo.getHostAddresses()[0]);
//
//                latch.countDown();
//
//            }
//
//            @Override
//            public void serviceRemoved(ServiceEvent event) {
//                System.out.println("Math Service removed: " + event.getInfo());
//
//
//            }
//
//            @Override
//            public void serviceAdded(ServiceEvent event) {
//                System.out.println("Math Service added: " + event.getInfo());
//
//
//            }
//        });
//
//        // Wait a bit
//        Thread.sleep(2000);
//        latch.await();
//
//
////        jmdns.close();
//
//    } catch (UnknownHostException e) {
//        System.out.println(e.getMessage());
//    } catch (IOException e) {
//        System.out.println(e.getMessage());
//    } catch (InterruptedException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }

//    try {
//        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
//        ServiceInfo[] serviceInfos = jmdns.list(service_type);
//        if (serviceInfos.length > 0) {
//            PollutionSensorServiceInfo = serviceInfos[0];
//            System.out.println("Math Service resolved: " + PollutionSensorServiceInfo);
//
//            int port = PollutionSensorServiceInfo.getPort();
//            System.out.println("resolving " + service_type + " with properties ...");
//            System.out.println("\t port: " + port);
//            System.out.println("\t host: " + PollutionSensorServiceInfo.getHostAddresses()[0]);
//        }
//        jmdns.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//
//}

//public GUIClient(){
//    String pollution_sensor_service_type = "_pollution-sensor._tcp.local.";
//    discoverMathService(pollution_sensor_service_type);
//
//    if (PollutionSensorServiceInfo != null) {
//        String host = PollutionSensorServiceInfo.getHostAddresses()[0];
//        int port = PollutionSensorServiceInfo.getPort();
//
//        ManagedChannel channel = ManagedChannelBuilder
//                .forAddress(host, port)
//                .usePlaintext()
//                .build();
//    }
//}


    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter a city")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Get pollution data");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 100);
        reply1 .setEditable(false);
        panel.add(reply1 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter Location")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Get Data of Last 3 Days");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextArea("",20,100);
        reply2.setEditable(false);
//        reply2.setPreferredSize(new Dimension(reply2.getPreferredSize().width, 50));
        panel.add(reply2);



        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

       JLabel label = new JLabel("Enter Location:");
        panel.add(label);

        entry3 = new JTextField();
        panel.add(entry3);

        JButton addButton = new JButton("Add City");
        addButton.addActionListener(this);
        panel.add(addButton);

        reply3 = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(reply3);
        reply3.setEditable(false);
        panel.add(scrollPane);

        JButton completeButton = new JButton("Average");
        completeButton.addActionListener(this);
        panel.add(completeButton);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JButton button = new JButton("Get Trending Locations");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextArea(10, 10);
        JScrollPane scrollPane = new JScrollPane(reply4);
        panel.add(scrollPane);
        reply4 .setEditable(false);
//        panel.add(reply4 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService5JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter Location")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry5 = new JTextField("",10);
        panel.add(entry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Get Live Trends");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply5 = new JTextArea("",20,100);
        reply5.setEditable(false);
//        reply2.setPreferredSize(new Dimension(reply2.getPreferredSize().width, 50));
        panel.add(reply5);



        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService6JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter Location")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry6 = new JTextField("",10);
        panel.add(entry6);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel label1 = new JLabel("Enter Alert Message")	;
        panel.add(label1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry7 = new JTextField("",50);
        panel.add(entry7);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Send Alert");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply6 = new JTextArea(20, 100);
        reply6 .setEditable(false);
        panel.add(reply6);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService8JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter Broadcast Location: ");
        panel.add(label);

        entry8 = new JTextField();
        panel.add(entry8);

        JLabel label1 = new JLabel("Enter Alert Message:");
        panel.add(label1);

        entry9 = new JTextField();
        panel.add(entry9);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        panel.add(addButton);

        reply8 = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(reply8);
        reply8.setEditable(false);
        panel.add(scrollPane);

        JButton completeButton = new JButton("Broadcast Alerts");
        completeButton.addActionListener(this);
        panel.add(completeButton);

        panel.setLayout(boxlayout);

        return panel;

    }

    public static void main(String[] args) throws InterruptedException {

        GUIClient gui = new GUIClient();

        gui.build();

        try {

            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_pollution-sensor._tcp.local.", new MyServiceListener());
            jmdns.addServiceListener("_pollution-analysis._tcp.local.", new MyServiceListener());
            jmdns.addServiceListener("_alert-service._tcp.local.", new MyServiceListener());

            // Wait a bit
            Thread.sleep(20000);

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    private void build() {

        JFrame frame = new JFrame("Smart Polution Tracking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getService1JPanel() );
        panel.add( getService2JPanel() );
        panel.add( getService3JPanel() );
        panel.add( getService4JPanel() );
        panel.add( getService5JPanel() );
        panel.add( getService6JPanel() );
        panel.add( getService8JPanel() );
        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();
        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        if (label.equals("Get pollution data")) {

            System.out.println("Get pollution data to be invoked ...");

//            ManagedChannel channel1 = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            PollutionSensorServiceGrpc.PollutionSensorServiceBlockingStub blockingStub = PollutionSensorServiceGrpc.newBlockingStub(channel1);

            //preparing message to send
            GetPollutionDataRequest request = GetPollutionDataRequest.newBuilder().setLocation(entry1.getText()).build();

            //retreving reply from service
            PollutionData response = blockingStub.getPollutionData(request);

            reply1.setText(String.valueOf(response));


        }else if (label.equals("Get Data of Last 3 Days")) {

            System.out.println("Get the data of the last three days to be invoked ...");

//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            PollutionSensorServiceGrpc.PollutionSensorServiceBlockingStub blockingStub = PollutionSensorServiceGrpc.newBlockingStub(channel1);

            //preparing message to send
            GetCityMultiplePollutionDataRequest request = GetCityMultiplePollutionDataRequest.newBuilder().setLocation(entry2.getText()).setNumOfDays(3).build();

            //retreving reply from service
            try {
                Iterator<PollutionData> responces = blockingStub.getCityMultiplePollutionData(request);
                while(responces.hasNext()) {
                    PollutionData temp = responces.next();
                    reply2.append(String.valueOf(temp));
                }
            } catch (StatusRuntimeException ex) {
            ex.printStackTrace();
            }

        }else if (label.equals("Add City")) {

            System.out.println("Add City");

            String location = entry3.getText().trim();
            if (!location.isEmpty()) {
                locations.add(location);
                reply3.append(location + "\n");
                entry3.setText("");
            }

        } else if (label.equals("Average")) {
            if (!locations.isEmpty()) {
                // send request to server with all locations in the list
//                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

                PollutionSensorServiceGrpc.PollutionSensorServiceStub asyncStub = PollutionSensorServiceGrpc.newStub(channel1);


                StreamObserver<PollutionData> responseObserver = new StreamObserver<PollutionData>() {

                    @Override
                    public void onNext(PollutionData msg) {
                        reply3.append(msg.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("stream is completed ... receiveing all cities");
                    }

                };

                StreamObserver<GetAveragePollutionDataRequest> requestObserver = asyncStub.getAveragePollutionData(responseObserver);

                try {


                    for (int i = 0; i < locations.size(); i++) {
                        requestObserver.onNext(GetAveragePollutionDataRequest.newBuilder().setLocation(locations.get(i)).build());
                        Thread.sleep(500);
                    }

                    // Mark the end of requests
                    requestObserver.onCompleted();


                    Thread.sleep(1000);

                } catch (RuntimeException exc) {
                    exc.printStackTrace();
                } catch (InterruptedException exce) {
                    exce.printStackTrace();
                }


            }

        }else if(label.equals("Get Trending Locations")){

            System.out.println("Get Trending Locations to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            PollutionAnalysisServiceGrpc.PollutionAnalysisServiceBlockingStub blockingStub = PollutionAnalysisServiceGrpc.newBlockingStub(channel);

            //preparing message to send
            TrendingRequest request = TrendingRequest.newBuilder().build();

            //retreving reply from service
            TrendingLocations response = blockingStub.getTrendingLocations(request);
            reply4.setText(response.toString());

        }else if (label.equals("Get Live Trends")) {
            System.out.println("Get Live Trends to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            PollutionAnalysisServiceGrpc.PollutionAnalysisServiceBlockingStub blockingStub = PollutionAnalysisServiceGrpc.newBlockingStub(channel);


            //preparing message to send
            List<String> locationsList = Arrays.asList(entry5.getText().split("\\s*,\\s*"));
            LiveTrendsRequest request = LiveTrendsRequest.newBuilder().addAllLocations(locationsList).build();

            //retreving reply from service
                try {
                    Iterator<PollutionAnalysis> responces = blockingStub.getLiveTrends(request);
                    while(responces.hasNext()) {
                        PollutionAnalysis temp = responces.next();
                        reply5.append(String.valueOf(temp));
                    }
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                }

        }else if(label.equals("Send Alert")) {

            System.out.println("Send Alert to be invoked ...");

            ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            AlertServiceGrpc.AlertServiceBlockingStub blockingStub = AlertServiceGrpc.newBlockingStub(channel3);

            //preparing message to send
            Alert request = Alert.newBuilder().setLocation(entry6.getText()).setMessage(entry7.getText()).build();

            //retreving reply from service
            AlertConfirmation response = blockingStub.sendAlert(request);

            reply6.setText(String.valueOf(response));

        }else if(label.equals("Add")){
            System.out.println("Add locations that want to send alerts");

            String location = entry8.getText();
            String message = entry9.getText();
            if (!location.isEmpty()) {
                broadcastLocations.add(location);
                broadcastMessage.add(message);
                reply8.append(location + ": " +message + "\n");
                entry8.setText("");
                entry9.setText("");
            }


        } else if(label.equals("Broadcast Alerts")){

//            if (!(broadcastLocations.isEmpty() && broadcastMessage.isEmpty())) {
                // send request to server with all locations in the list
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

                AlertServiceGrpc.AlertServiceStub asyncStub = AlertServiceGrpc.newStub(channel);

                StreamObserver<AlertConfirmation> responseObserver = new StreamObserver<AlertConfirmation>() {

                    int count =0 ;
                    @Override
                    public void onNext(AlertConfirmation msg) {

                        reply8.append(String.valueOf(msg));
                        count += 1;

                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("BroadcastAlerts stream is completed ... sent "+ count+ " alerts");
                        // Shutdown the channel
                        channel.shutdown();

                        try {
                            // Wait for the channel to terminate
                            if (!channel.awaitTermination(5, TimeUnit.SECONDS)) {
                                // Force shutdown if it doesn't terminate within the specified time
                                channel.shutdownNow();
                            }
                        } catch (InterruptedException e) {
                            // Force shutdown in case of an InterruptedException
                            channel.shutdownNow();
                        }
                    }

                };

                StreamObserver<Alert> requestObserver = asyncStub.broadcastAlerts(responseObserver);

                try {

                    for (int i = 0; i < broadcastLocations.size(); i++) {
                        requestObserver.onNext(Alert.newBuilder().setLocation(broadcastLocations.get(i)).setMessage(broadcastMessage.get(i)).build());
                        Thread.sleep(500);
                    }


                    // Mark the end of requests
                    requestObserver.onCompleted();

                    Thread.sleep(1000);

                } catch (RuntimeException exception) {
                    exception.printStackTrace();
                } catch (InterruptedException excep) {
                    excep.printStackTrace();
                }


            }
        }





        /*
             *
             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
//            PollutionSensorService.PollutionSenserServiceBlockingStub blockingStub = PollutionSensorServiceGrpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.PollutionSensorService.RequestMessage request = ds.PollutionSensorService.RequestMessage.newBuilder().setText(entry1.getText()).build();
//
//            //retreving reply from service
//            ds.PollutionSensorService.ResponseMessage response = blockingStub.service1Do(request);
//
//            reply1.setText( String.valueOf( response.getLength()) );

//        }else if (label.equals("Invoke Service 2")) {
//            System.out.println("service 2 to be invoked ...");
//
//
//            /*
//             *
//             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
//            Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service2.RequestMessage request = ds.service2.RequestMessage.newBuilder().setText(entry2.getText()).build();
//
//            //retreving reply from service
//            ds.service2.ResponseMessage response = blockingStub.service2Do(request);
//
//            reply2.setText( String.valueOf( response.getLength()) );
//
//        }else if (label.equals("Invoke Service 3")) {
//            System.out.println("service 3 to be invoked ...");
//
//
//            /*
//             *
//             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
//            Service3Grpc.Service3BlockingStub blockingStub = Service3Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service3.RequestMessage request = ds.service3.RequestMessage.newBuilder().setText(entry3.getText()).build();
//
//            //retreving reply from service
//            ds.service3.ResponseMessage response = blockingStub.service3Do(request);
//
//            reply3.setText( String.valueOf( response.getLength()) );
//
//        }else if (label.equals("Invoke Service 4")) {
//            System.out.println("service 4 to be invoked ...");
//
//
//            /*
//             *
//             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
//            Service4Grpc.Service4BlockingStub blockingStub = Service4Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service4.RequestMessage request = ds.service4.RequestMessage.newBuilder().setText(entry4.getText()).build();
//
//            //retreving reply from service
//            ds.service4.ResponseMessage response = blockingStub.service4Do(request);
//
//            reply4.setText( String.valueOf( response.getLength()) );
//
//        }else{
//
//        }


//        private static JmDNS jmdns;
//        private static String pollutionSensorServiceAddress = "_pollution-sensor._tcp.local.";
//        private static int pollutionSensorServicePort = 50051;
//        private static String pollutionAnalysisServiceAddress = "_pollution-analysis._tcp.local.";
//        private static int pollutionAnalysisServicePort = 50052;
//        private static String alertServiceAddress = "_alert-service._tcp.local.";
//        private static int alertServicePort = 50053;
//
//
//
//        public static void main(String[] args) throws IOException {
//            jmdns = JmDNS.create(InetAddress.getLocalHost());
//            jmdns.addServiceListener("_pollution-sensor._tcp.local.", new SampleServiceListener());
//            jmdns.addServiceListener("_pollution-analysis._tcp.local.", new SampleServiceListener());
//            jmdns.addServiceListener("_alert-service._tcp.local.", new SampleServiceListener());

//
//            JTextField textNumber1;
//            JTextField textNumber2;
//            JTextArea textResponse ;
//
//
//            // Create and set up the window.
//            JFrame frame = new JFrame("Smart Pollution Tracker");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(1000, 500);
//            frame.setVisible(true);
//
//
//            BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
//
//            frame.getContentPane().setLayout(bl);
//
//            JPanel panel_service_1 = new JPanel();
//            panel_service_1.setVisible(true);
//            frame.getContentPane().add(panel_service_1);
//            panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//
//            JLabel lblNewLabel_1 = new JLabel("Number 1");
//            panel_service_1.add(lblNewLabel_1);
//
//            textNumber1 = new JTextField();
//            panel_service_1.add(textNumber1);
//            textNumber1.setColumns(10);
//
//            JLabel lblNewLabel_2 = new JLabel("Number 2");
//            panel_service_1.add(lblNewLabel_2);
//
//            textNumber2 = new JTextField();
//            panel_service_1.add(textNumber2);
//            textNumber2.setColumns(10);
//
//
//            JComboBox comboOperation = new JComboBox();
//            comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
//            panel_service_1.add(comboOperation);
//
//
//            JButton btnCalculate = new JButton("Calculate");
//            btnCalculate.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//
//                    int num1 = Integer.parseInt(textNumber1.getText());
//                    int num2 = Integer.parseInt(textNumber2.getText());
//
//                    int index = comboOperation.getSelectedIndex();
//                    Operation operation = Operation.forNumber(index);
//
//                    CalculateRequest req = CalculateRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(operation).build();
//
//                    CalculateResponse response = blockingStub.calculate(req);
//
//                    textResponse.append("reply:"+ response.getResult() + " mes:"+ response.getMessage() + "\n");
//
//                    System.out.println("res: " + response.getResult() + " mes: " + response.getMessage());
//
//                }
//            });
//            panel_service_1.add(btnCalculate);
//
//            textResponse = new JTextArea(3, 20);
//            textResponse .setLineWrap(true);
//            textResponse.setWrapStyleWord(true);
//
//            JScrollPane scrollPane = new JScrollPane(textResponse);
//
//            //textResponse.setSize(new Dimension(15, 30));
//            panel_service_1.add(scrollPane);
//
//
//            JPanel panel_service_2 = new JPanel();
//            frame.getContentPane().add(panel_service_2);
//
//            JPanel panel_service_3 = new JPanel();
//            frame.getContentPane().add(panel_service_3);


            // Set up the content pane.
//            JPanel panel = new JPanel();
//            frame.setContentPane(panel);
//            panel.setLayout(new GridLayout(3, 10));
//
//            JButton pollutionSensorButton = new JButton("Pollution Sensor Service");
//            JButton pollutionAnalysisButton = new JButton("Pollution Analysis Service");
//            JButton alertServiceButton = new JButton("Alert Service");
//
//            panel.add(pollutionSensorButton);
//            panel.add(pollutionAnalysisButton);
//            panel.add(alertServiceButton);
//
//
//
//            // Add action listeners to buttons
//            pollutionSensorButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Perform actions specific to PollutionSensorService
//                    // Example: Call gRPC methods using pollutionSensorServiceAddress and pollutionSensorServicePort
//
//                }
//            });
//
//            pollutionAnalysisButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Perform actions specific to PollutionAnalysisService
//                    // Example: Call gRPC methods using pollutionAnalysisServiceAddress and pollutionAnalysisServicePort
//                }
//            });
//
//            alertServiceButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Perform actions specific to AlertService
//                    // Example: Call gRPC methods using alertServiceAddress and alertServicePort
//                }
//            });
//
//            // Display the window.
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        }
//

//
//
//            public void serviceResolved(ServiceInfo info) {
//                if (info.getType().equals("_pollution-sensor._tcp.local.")) {
//                    pollutionSensorServiceAddress = info.getHostAddresses()[0];
//                    pollutionSensorServicePort = info.getPort();
//                } else if (info.getType().equals("_pollution-analysis._tcp.local.")) {
//                    pollutionAnalysisServiceAddress = info.getHostAddresses()[0];
//                    pollutionAnalysisServicePort = info.getPort();
//                } else if (info.getType().equals("_alert-service._tcp.local.")) {
//                    alertServiceAddress = info.getHostAddresses()[0];
//                    alertServicePort = info.getPort();
//                }
//            }
//        }
}


