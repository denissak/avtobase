package Mapper;

public interface Mapper<F, S> {
    S mapFrom(F object);
}
