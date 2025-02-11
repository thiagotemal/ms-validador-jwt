package br.com.temal.sec.tokenvalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Claim {
    private String name;
    private String value;
    private String status;
}
