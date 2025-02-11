package br.com.temal.sec.tokenvalidator.adapters.in.validation;

import br.com.temal.sec.tokenvalidator.application.ports.in.validation.PrimeNumberVerifierValidator;

public class PrimeNumberValidatorImplValidator implements PrimeNumberVerifierValidator {
    @Override
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}