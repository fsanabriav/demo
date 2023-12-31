package com.api.mutanthuman.domain.strategy;

import com.api.mutanthuman.domain.exception.ApplicationException;
import com.api.mutanthuman.domain.strategy.specificstrategy.SearchStrategyDiagonalsToDown;
import com.api.mutanthuman.domain.strategy.specificstrategy.SearchStrategyDiagonalsToUp;
import com.api.mutanthuman.domain.strategy.specificstrategy.SearchStrategyHotizontal;
import com.api.mutanthuman.domain.strategy.specificstrategy.SearchStrategyVertical;

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
        final Map<String, Supplier<ISearchStrategy>> searchStrategy = new HashMap<>();
        searchStrategy.put(SearchStrategyType.HORIZONTAL.name(), SearchStrategyHotizontal::new);
        searchStrategy.put(SearchStrategyType.VERTICAL.name(), SearchStrategyVertical::new);
        searchStrategy.put(SearchStrategyType.DIAGONALS_TO_DOWN.name(), SearchStrategyDiagonalsToDown::new);
        searchStrategy.put(SearchStrategyType.DIAGONALS_TO_UP.name(), SearchStrategyDiagonalsToUp::new);

        ESTRATEGIES = Collections.unmodifiableMap(searchStrategy);
    }
    public ISearchStrategy getSearchStrategy(String searchStrategy) {
        Supplier<ISearchStrategy> strategy = ESTRATEGIES.get(searchStrategy);
        if (strategy == null) {
            throw new ApplicationException("Invalid strategy type: " + searchStrategy);
        }
        return strategy.get();
    }
}
