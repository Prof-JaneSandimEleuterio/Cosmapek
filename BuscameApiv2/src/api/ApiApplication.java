package api;

import api.server.resource.impl.*;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MemoryRealm;
import org.restlet.security.Role;
import org.restlet.security.User;
import org.restlet.service.CorsService;

/**
 * Created by Junior Cupe on 8/25/2015.
 */
public class ApiApplication extends Application implements RouteTags, RoleTags {
    private String versionFull;
    private int versionMajor;
    private int versionMicro;
    private int versionMinor;

    public ApiApplication() {
        this.setName("Api");
        CorsService corsService = new CorsService();
        corsService.setAllowedCredentials(true);
        corsService.setSkippingResourceForCorsOptions(true);
        this.getServices().add(corsService);

    }

    @Override public Restlet createInboundRoot() {
        // Router for the API's resources
        Router apiRouter = createApiRouter();
        // Protect the set of resources
        ChallengeAuthenticator guard = createApiGuard(apiRouter);
        return guard;

    }

    private Router createApiRouter() {
        Router apiRouter = new Router(getContext());

        //resources
        apiRouter.attach(Route_Companies, CompaniesServerResource.class);
        apiRouter.attach(Route_Companies_, Companies_ServerResource.class);
        apiRouter.attach(Route_Companies_id, Companies_idServerResource.class);
        apiRouter.attach(Route_Companies_id_Configurations_, Companies_id_Configurations_ServerResource.class);
        apiRouter.attach(Route_Companies_id_Products_, Companies_id_Products_ServerResource.class);
        apiRouter.attach(Route_Companies_id_Localizations_, Companies_id_Localizations_ServerResource.class);

        apiRouter.attach(Route_Companies_id_OperationHour_, Companies_id_OperationHour_ServerResource.class);
        apiRouter.attach(Route_Companies_id_ProductGroups_, Companies_id_ProductGroups_ServerResource.class);
        apiRouter.attach(Route_Companies_id_ProductGroups_id, Companies_id_ProductGroups_idServerResource.class);
        apiRouter.attach(Route_Companies_id_ProductGroups_id_Products_, Companies_id_ProductGroups_id_Products_ServerResource.class);

        apiRouter.attach(Route_Clients, ClientsServerResource.class);
        apiRouter.attach(Route_Clients_, Clients_ServerResource.class);
        apiRouter.attach(Route_Clients_id, Clients_idServerResource.class);
        apiRouter.attach(Route_Clients_id_Configurations_, Clients_id_Configurations_ServerResource.class);
        apiRouter.attach(Route_Clients_id_Localizations_, Clients_id_Localizations_ServerResource.class);
        apiRouter.attach(Route_Products, ProductsServerResource.class);
        apiRouter.attach(Route_products_, Products_ServerResource.class);
        apiRouter.attach(Route_products_id, Products_idServerResource.class);


        final String Route_Images = "/images"; // important
        final String Route_Images_ = "/images/";
        final String Route_Images_id = "/images/{imageId}";
        apiRouter.attach(Route_Images, ProductsServerResource.class);
        apiRouter.attach(Route_Images_, Products_ServerResource.class);
        apiRouter.attach(Route_Images_id, Products_idServerResource.class);

        return apiRouter;
    }

    private ChallengeAuthenticator createApiGuard(Restlet next) {

        ChallengeAuthenticator apiGuard = new ChallengeAuthenticator(
            getContext(), ChallengeScheme.HTTP_BASIC, "realm");

        // Create in-memory users and roles.
        MemoryRealm realm = new MemoryRealm();
        User owner = new User("owner", "owner");
        realm.getUsers().add(owner);
        realm.map(owner, Role.get(this, ROLE_OWNER));
        realm.map(owner, Role.get(this, ROLE_USER));
        realm.map(owner, Role.get(this, ROLE_DEV));
        User admin = new User("admin", "admin");
        realm.getUsers().add(admin);
        realm.map(admin, Role.get(this, ROLE_ADMIN));
        realm.map(admin, Role.get(this, ROLE_OWNER));
        realm.map(admin, Role.get(this, ROLE_USER));
        realm.map(admin, Role.get(this, ROLE_DEV));
        User user = new User("user", "user");
        realm.getUsers().add(user);
        realm.map(user, Role.get(this, ROLE_USER));

        // Verifier : to check authentication
        apiGuard.setVerifier(realm.getVerifier());
        // Enroler : add authorization roles
        apiGuard.setEnroler(realm.getEnroler());

        // You can also create your own authentication/authorization system by
        // creating classes extending SecretVerifier or LocalVerifier (for
        // authentication) and Enroler (for authorization) and set these to the
        // guard.

        apiGuard.setNext(next);//filter

        // In case of anonymous access supported by the API.
        apiGuard.setOptional(true);//True if the authentication success is optional.

        return apiGuard;
    }
}
