package com.example.getarrays.service.Impl;

import com.example.getarrays.modal.Server;
import com.example.getarrays.repo.ServerRepo;
import com.example.getarrays.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import static com.example.getarrays.enumaration.Status.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServiceImpl implements ServerService {

    private final ServerRepo serverRepo;

    @Override
    public Server createServer(Server server) {
        log.info("Saving new Server : {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}",ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers ");
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server getAServer(Long id) {
        log.info("Fetching a server by id: {}", id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Server updateServer(Server server) {
        log.info("Updating a server");
        return serverRepo.save(server);
    }

    @Override
    public Boolean deleteServer(Long id) {
        log.info("Deleting a server by id: {}", id);
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }
    private String setServerImageUrl() {
        String imageNames[] = {"server1.png" , "server2.png" , "server3.png" ,"server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
}
