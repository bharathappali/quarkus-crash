package dev.doofenshmirtz;

import dev.doofenshmirtz.svc.SystemAllocatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/alloc")
@Produces(MediaType.APPLICATION_JSON)
public class SystemOom {

    @Inject
    SystemAllocatorService svc;

    @GET
    @Path("/hit")
    public SystemAllocatorService.Result hit() {
        return svc.onRequest();
    }
}
