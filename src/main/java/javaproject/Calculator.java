package javaproject;

public interface Calculator<T extends Number> {

    abstract double calculateFees(T clubId);
}
