package presentation.data;

import java.time.format.DateTimeFormatter;

import presentation.gui.GuiConstants;
import presentation.gui.GuiUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import business.ordersubsystem.OrderImpl;

public class OrderPres {
	private OrderImpl order;
	
	public OrderImpl getOrder() {
		return order;
	}

	public void setOrder(OrderImpl order) {
		this.order = order;
	}
	public SimpleStringProperty orderIdProperty() {
		return new SimpleStringProperty(String.valueOf(order.getOrderId()));
	}
	public SimpleStringProperty dateProperty() {
		return new  SimpleStringProperty(
			order.getOrderDate().format(
				DateTimeFormatter.ofPattern(GuiConstants.DATE_FORMAT)));
		
	}
	public SimpleStringProperty totalPriceProperty() {
		return new SimpleStringProperty(
				String.format("%.2f", order.getTotalPrice()));
	}

	public ObservableList<OrderItemPres> getOrderItemsPres() {
		return GuiUtils.orderItemsToOrderItemsPres(order.getOrderItems());
	}
	
}
