package indi.wuyue.grpc.test.server;

import indi.wuyue.grpc.test.GreeterGrpc;
import indi.wuyue.grpc.test.Heloworld;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloWorldServer extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(Heloworld.HelloRequest request, StreamObserver<Heloworld.HelloReply> responseObserver) {
        System.out.println(String.format("hello, %s!", request.getName()));
    }

    public static void main(String[] args) throws Exception {
        // 服务的添加：
        io.grpc.Server server = ServerBuilder.forPort(9090).addService(new HelloWorldServer()).build();
        // 服务的启动：
        server.start();
        System.out.println("=====start");
        // 服务的关闭：
        server.awaitTermination();
    }

}
