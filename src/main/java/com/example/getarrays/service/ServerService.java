package com.example.getarrays.service;

import com.example.getarrays.modal.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {

    Server createServer(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server getAServer(Long id);
    Server updateServer(Server server);
    Boolean deleteServer(Long id);
}
