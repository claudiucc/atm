package com.infoworld.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.OK;

public class Responses {
    public static final ResponseEntity<Void> EMPTY_OK_RESPONSE = new ResponseEntity<Void>(OK);
    
    public static <E> ResponseEntity<E> newEntityOrError(final Supplier<E> supplier) {
        final E obj = supplier.get();
        return obj == null
                        ? new ResponseEntity<E>(HttpStatus.NO_CONTENT)
                        : new ResponseEntity<E>(obj, HttpStatus.OK);
    }

    public static <E> ResponseEntity<List<E>> newEntityWithListOrError(final Supplier<List<E>> supplier) {
        final List<E> list = supplier.get();
        return list.isEmpty()
                        ? new ResponseEntity<List<E>>(HttpStatus.NO_CONTENT)
                        : new ResponseEntity<List<E>>(list, HttpStatus.OK);
    }
    
    public static <E> ResponseEntity<Set<E>> newEntityWithSetOrError(final Supplier<Set<E>> supplier) {
        final Set<E> set = supplier.get();
        return set.isEmpty()
                        ? new ResponseEntity<Set<E>>(HttpStatus.NO_CONTENT)
                        : new ResponseEntity<Set<E>>(set, HttpStatus.OK);
    }

    public static <I, E> ResponseEntity<Map<I, E>> newEntityWithMapOrError(final Supplier<Map<I, E>> supplier) {
        final Map<I, E> map = supplier.get();
        return map.isEmpty()
                ? new ResponseEntity<Map<I, E>>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<Map<I, E>>(map, HttpStatus.OK);
    }
}
