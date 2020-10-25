package io.github.hsedjame.grcpclient;

import io.github.hsedjame.grcpserver.PingPongServiceGrpc;
import io.github.hsedjame.grcpserver.PingRequest;
import io.github.hsedjame.grcpserver.PingResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GrcpClientService {

    public String ping() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        PingPongServiceGrpc.PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);

        PingResponse response = stub.ping(PingRequest.newBuilder()
                .setPing("")
                .build());

        channel.shutdown();

        return response.getPong();
    }
}
