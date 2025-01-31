package study.commerceservice.domain.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.commerceservice.common.CommonTimeEntity;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentLine extends CommonTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "payment_line_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public PaymentLine(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
