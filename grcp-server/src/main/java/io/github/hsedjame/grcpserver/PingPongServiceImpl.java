package io.github.hsedjame.grcpserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {

        PingResponse response = PingResponse.newBuilder()
                .setPong("Pong")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
