package com.api.mutanthuman.domain.strategy;

import com.api.mutanthuman.domain.exception.ApplicationException;
import com.api.mutanthuman.domain.strategy.strategyspecific.SearchStrategyDiagonalsToDown;
import com.api.mutanthuman.domain.strategy.strategyspecific.SearchStrategyDiagonalsToUp;
import com.api.mutanthuman.domain.strategy.strategyspecific.SearchStrategyHotizontal;
import com.api.mutanthuman.domain.strategy.strategyspecific.SearchStrategyVertical;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Fabrica para obtener las instancias de las diferentes estrategias
 */
public class StrategyFactory {
    private static final Map<String, Supplier<ISearchStrategy>> ESTRATEGIES;

    static {
        final Map<String, Supplier<ISearchStrategy>> searchStrategiea = new HashMap<>();
        searchStrategiea.put(SearchStrategyType.HORIZONTAL.name(), SearchStrategyHotizontal::new);
        searchStrategiea.put(SearchStrategyType.VERTICAL.name(), SearchStrategyVertical::new);
        searchStrategiea.put(SearchStrategyType.DIAGONALS_TO_DOWN.name(), SearchStrategyDiagonalsToDown::new);
        searchStrategiea.put(SearchStrategyType.DIAGONALS_TO_UP.name(), SearchStrategyDiagonalsToUp::new);

        ESTRATEGIES = Collections.unmodifiableMap(searchStrategiea);
    }
    public ISearchStrategy getSearchStrategy(String searchStratey) {
        Supplier<ISearchStrategy> strategy = ESTRATEGIES.get(searchStratey);
        if (strategy == null) {
            throw new ApplicationException("Invalid strategy type: " + searchStratey);
        }
        return strategy.get();
    }
}
