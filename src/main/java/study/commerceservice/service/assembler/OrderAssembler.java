package study.commerceservice.service.assembler;

import study.commerceservice.domain.order.Order;
import study.commerceservice.domain.order.OrderLine;
import study.commerceservice.domain.order.PaymentLine;
import study.commerceservice.dto.CheckOutDto;
import study.commerceservice.dto.OrderDto;
import study.commerceservice.dto.PaymentLineDto;
import study.commerceservice.dto.ProductOptionDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderAssembler {
    public static Order toEntity() {
        // TODO
        return null;
    }

    public static OrderDto toOrderDto(Order order) {
        List<OrderLine> orderLines = order.getOrderLines();
        List<ProductOptionDto> productOptionDtos = orderLines.stream().map(OrderLineAssembler::toDto)
                .collect(Collectors.toList());

        List<PaymentLine> paymentLines = order.getPaymentLines();
        List<PaymentLineDto> paymentLineDtos = paymentLines.stream().map(PaymentLineAssembler::toDto)
                .collect(Collectors.toList());

        return OrderDto.builder()
                .orderId(order.getId())
                .orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .productOptionDtos(productOptionDtos)
                .paymentLineDtos(paymentLineDtos)
                .shippingInfoDto(ShippingInfoAssembler.toDto(order.getShippingInfo()))
                .totalPrice(order.getTotalPrice())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    public static CheckOutDto toCheckOutDto(Order preOrder) {
        List<OrderLine> orderLines = preOrder.getOrderLines();
        List<ProductOptionDto> productOptionDtos = orderLines.stream().map(OrderLineAssembler::toDto)
                .collect(Collectors.toList());

        return CheckOutDto.builder()
                .orderId(preOrder.getId())
                .productOptionDtos(productOptionDtos)
                .totalPrice(preOrder.getTotalPrice())
                .build();
    }
}
