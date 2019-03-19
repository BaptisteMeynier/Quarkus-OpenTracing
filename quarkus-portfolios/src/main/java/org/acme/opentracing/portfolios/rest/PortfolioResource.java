package org.acme.opentracing.portfolios.rest;

import org.acme.opentracing.portfolios.client.UsersService;
import org.acme.opentracing.portfolios.model.Portfolio;
import org.acme.opentracing.portfolios.model.User;
import org.acme.opentracing.portfolios.service.PortfoliosService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@Path("/portfolio")
public class PortfolioResource {

    @Inject
    PortfoliosService portfoliosService;

    @Inject
    @RestClient
    UsersService usersService;

    @GET
    @Path("{ptfCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Portfolio portfolio(@PathParam("ptfCode") @NotEmpty String ptfCode) {

        final User user = usersService.getOwner(ptfCode);

        final Optional<Portfolio> portfolio = portfoliosService.getPortfolios()
                .stream()
                .filter(ptf -> ptfCode.equalsIgnoreCase(ptf.getCode()))
                .findFirst();
        portfolio.ifPresent(ptf -> ptf.setManager(user));

        return portfolio.orElse(new Portfolio("INEXISTING PORTFOLIO",0));
    }

}