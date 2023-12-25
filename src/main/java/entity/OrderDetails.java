package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class      OrderDetails {
    private String orderId;
    private String itemCode;
    private double unitPrice;
    private int qty;

}
