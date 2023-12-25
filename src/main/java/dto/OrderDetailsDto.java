package dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetailsDto {
    private String orderId;
    private String code;
    private double unitPrice;
    private int qty;


}
