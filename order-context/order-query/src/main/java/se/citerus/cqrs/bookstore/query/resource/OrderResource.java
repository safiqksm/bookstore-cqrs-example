package se.citerus.cqrs.bookstore.query.resource;

import se.citerus.cqrs.bookstore.event.DomainEvent;
import se.citerus.cqrs.bookstore.event.DomainEventStore;
import se.citerus.cqrs.bookstore.query.OrderProjection;
import se.citerus.cqrs.bookstore.query.QueryService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("orders")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class OrderResource {

  private final QueryService queryService;
  private final DomainEventStore eventStore;

  public OrderResource(QueryService queryService, DomainEventStore eventStore) {
    this.queryService = queryService;
    this.eventStore = eventStore;
  }

  @GET
  @Path("events")
  public List<DomainEvent> getAllEvents() {
    return eventStore.getAllEvents();
  }

  @GET
  public Collection<OrderProjection> getAllOrders() {
    return queryService.listOrders();
  }

}