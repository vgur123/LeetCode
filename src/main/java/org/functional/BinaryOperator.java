package org.functional;

import java.util.function.Function;

public interface BinaryOperator extends
        Function<Integer, Function<Integer, Integer>> {}