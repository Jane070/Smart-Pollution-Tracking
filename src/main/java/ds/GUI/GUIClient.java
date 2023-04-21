package ds.GUI;

import ds.alertservice.Alert;
import ds.alertservice.AlertConfirmation;
import ds.alertservice.AlertServiceGrpc;
import ds.pollutionanalysisservice.*;
import ds.pollutionsensorservice.*;
import io.grpc.*;
import io.grpc.stub.ClientCallStreamObserver;
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
import java.util.*;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: GUIClient
 * Description:
 *
 * @Author: Jiaxin Zhang
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
//    private final CountDownLatch latch = new CountDownLatch(1);
    private List<ServiceInfo> serviceInfos = new ArrayList<>();

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
//        ManagedChannel channel1 = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        if (label.equals("Get pollution data")) {

            System.out.println("Get pollution data to be invoked ...");

            ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext();
            channelBuilder.keepAliveTimeout(60, TimeUnit.SECONDS);
            channelBuilder.keepAliveWithoutCalls(true);
            ManagedChannel channel = channelBuilder.build();

            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
            Metadata headers = new Metadata();
            headers.put(authKey, "Bearer 1111");

            CallCredentials callCredentials = new CallCredentials() {
                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };
            PollutionSensorServiceGrpc.PollutionSensorServiceBlockingStub blockingStub = PollutionSensorServiceGrpc.newBlockingStub(channel).withCallCredentials(callCredentials).withDeadlineAfter(60, TimeUnit.SECONDS);

            //preparing message to send
            GetPollutionDataRequest request = GetPollutionDataRequest.newBuilder().setLocation(entry1.getText()).build();

            //retreving reply from service
            try {
                PollutionData response = blockingStub.getPollutionData(request);
                reply1.setText(String.valueOf(response));
            } catch (StatusRuntimeException ex) {
                System.err.println("Error occurred: " + ex.getMessage());
                ex.printStackTrace();
            }


        }else if (label.equals("Get Data of Last 3 Days")) {

            System.out.println("Get the data of the last three days to be invoked ...");

//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
            ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext();
            channelBuilder.keepAliveTimeout(60, TimeUnit.SECONDS);
            channelBuilder.keepAliveWithoutCalls(true);
            ManagedChannel channel = channelBuilder.build();

            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
            Metadata headers = new Metadata();
            headers.put(authKey, "Bearer 1111");
            CallCredentials callCredentials = new CallCredentials() {

                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };

            PollutionSensorServiceGrpc.PollutionSensorServiceBlockingStub blockingStub = PollutionSensorServiceGrpc.newBlockingStub(channel).withCallCredentials(callCredentials).withDeadlineAfter(60, TimeUnit.SECONDS);

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
                System.err.println("Error occurred: " + ex.getMessage());
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
                ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext();
                channelBuilder.keepAliveTimeout(60, TimeUnit.SECONDS);
                channelBuilder.keepAliveWithoutCalls(true);
                ManagedChannel channel = channelBuilder.build();
                Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
                Metadata headers = new Metadata();
                headers.put(authKey, "Bearer 1111");

                CallCredentials callCredentials = new CallCredentials() {

                    @Override
                    public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                        appExecutor.execute(() -> {
                            try {
                                applier.apply(headers);
                            } catch (Throwable e) {
                                applier.fail(Status.UNAUTHENTICATED.withCause(e));
                            }
                        });
                    }

                    @Override
                    public void thisUsesUnstableApi() {}
                };

                PollutionSensorServiceGrpc.PollutionSensorServiceStub asyncStub = PollutionSensorServiceGrpc.newStub(channel).withCallCredentials(callCredentials).withDeadlineAfter(60, TimeUnit.SECONDS);


                StreamObserver<PollutionData> responseObserver = new StreamObserver<PollutionData>() {

                    @Override
                    public void onNext(PollutionData msg) {
                        reply3.append(msg.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error occurred: " + t.getMessage());
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
                    System.err.println("Runtime exception occurred: " + exc.getMessage());
                    exc.printStackTrace();
                } catch (InterruptedException exce) {
                    System.err.println("Interrupted exception occurred: " + exce.getMessage());
                    exce.printStackTrace();
                }


            }

        }else if(label.equals("Get Trending Locations")){

            System.out.println("Get Trending Locations to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            // Create custom CallCredentials for authentication
            CallCredentials callCredentials = new CallCredentials() {

                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            Metadata headers = new Metadata();
                            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
                            headers.put(authKey, "Bearer 2222");
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };
            PollutionAnalysisServiceGrpc.PollutionAnalysisServiceBlockingStub blockingStub = PollutionAnalysisServiceGrpc.newBlockingStub(channel).withCallCredentials(callCredentials)
                    .withDeadlineAfter(5, TimeUnit.SECONDS);

            //preparing message to send
            TrendingRequest request = TrendingRequest.newBuilder().build();

            //retreving reply from service
            TrendingLocations response = blockingStub.getTrendingLocations(request);
            reply4.setText(response.toString());

        }else if (label.equals("Get Live Trends")) {
            System.out.println("Get Live Trends to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            // Create custom CallCredentials for authentication
            CallCredentials callCredentials = new CallCredentials() {

                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            Metadata headers = new Metadata();
                            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
                            headers.put(authKey, "Bearer 2222");
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };
            PollutionAnalysisServiceGrpc.PollutionAnalysisServiceBlockingStub blockingStub = PollutionAnalysisServiceGrpc.newBlockingStub(channel).withCallCredentials(callCredentials)
                    .withDeadlineAfter(5, TimeUnit.SECONDS);


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
                    if (ex.getStatus().getCode() == Status.Code.DEADLINE_EXCEEDED) {
                        System.err.println("Deadline exceeded for the RPC call.");
                    } else if (ex.getStatus().getCode() == Status.Code.UNAUTHENTICATED) {
                        System.err.println("Authentication failed.");
                    } else {
                        System.err.println("Error occurred: " + ex.getStatus().getDescription());
                    }
                    ex.printStackTrace();
                }

        }else if(label.equals("Send Alert")) {

            System.out.println("Send Alert to be invoked ...");

            ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
            // Create custom CallCredentials for authentication
            CallCredentials callCredentials = new CallCredentials() {

                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            Metadata headers = new Metadata();
                            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
                            headers.put(authKey, "Bearer 12345");
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };
            // Add call credentials and deadline to the stub
            AlertServiceGrpc.AlertServiceBlockingStub blockingStub = AlertServiceGrpc.newBlockingStub(channel3).withCallCredentials(callCredentials)
                    .withDeadlineAfter(5, TimeUnit.SECONDS);

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

                ManagedChannel channel3 = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

            // Create custom CallCredentials for authentication
            CallCredentials callCredentials = new CallCredentials() {

                @Override
                public void applyRequestMetadata(MethodDescriptor<?, ?> method, Attributes attrs, Executor appExecutor, MetadataApplier applier) {
                    appExecutor.execute(() -> {
                        try {
                            Metadata headers = new Metadata();
                            Metadata.Key<String> authKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
                            headers.put(authKey, "Bearer 12345");
                            applier.apply(headers);
                        } catch (Throwable e) {
                            applier.fail(Status.UNAUTHENTICATED.withCause(e));
                        }
                    });
                }

                @Override
                public void thisUsesUnstableApi() {}
            };
            // Add call credentials and deadline to the stub
                AlertServiceGrpc.AlertServiceStub asyncStub = AlertServiceGrpc.newStub(channel3).withCallCredentials(callCredentials)
                        .withDeadlineAfter(5, TimeUnit.SECONDS);

                StreamObserver<AlertConfirmation> responseObserver = new StreamObserver<AlertConfirmation>() {

                    int count =0 ;
                    @Override
                    public void onNext(AlertConfirmation msg) {
                        reply8.append(String.valueOf(msg));
                        count += 1;
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error occurred: " + t.getMessage());
                        t.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("BroadcastAlerts stream is completed ... sent "+ count+ " alerts");
                    }
                };


                    ClientCallStreamObserver<Alert> requestObserver = (ClientCallStreamObserver<Alert>) asyncStub.broadcastAlerts(responseObserver);
                try {
                    for (int i = 0; i < broadcastLocations.size(); i++) {
                        if (broadcastLocations.get(i) == null || broadcastMessage.get(i) == null) {
                            System.err.println("Error: Invalid broadcast location or message.");
                            requestObserver.cancel("Cancelled due to invalid input", null);
                            continue;
                        }
                        requestObserver.onNext(Alert.newBuilder().setLocation(broadcastLocations.get(i)).setMessage(broadcastMessage.get(i)).build());
                    }

                    // Mark the end of requests
                    requestObserver.onCompleted();

                    Thread.sleep(new Random().nextInt(1000) + 500);

                } catch (RuntimeException exception) {
                    System.err.println("Runtime exception occurred: " + exception.getMessage());
                    requestObserver.cancel("Cancelled due to runtime exception", null);
                    exception.printStackTrace();
                } catch (InterruptedException excep) {
                    System.err.println("Interrupted exception occurred: " + excep.getMessage());
                    requestObserver.cancel("Cancelled due to interrupted exception", null);
                    excep.printStackTrace();
                }


            }
        }

}


