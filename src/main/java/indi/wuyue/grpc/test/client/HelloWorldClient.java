package indi.wuyue.grpc.test.client;

import indi.wuyue.grpc.test.GreeterGrpc;
import indi.wuyue.grpc.test.Heloworld;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        stub.sayHello(Heloworld.HelloRequest.getDefaultInstance());
    }

}
