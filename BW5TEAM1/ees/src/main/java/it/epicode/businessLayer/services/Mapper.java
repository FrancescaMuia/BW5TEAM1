package it.epicode.businessLayer.services;

public interface Mapper<D, S> {

    S map(D input);
}
