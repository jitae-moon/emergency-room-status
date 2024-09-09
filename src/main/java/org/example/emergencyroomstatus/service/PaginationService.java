package org.example.emergencyroomstatus.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class PaginationService {

    private static final int PAGINATION_BAR_LENGTH = 5;

    public List<Integer> getPaginationBarNumbers(int currentPageNumber, int totalPagesCount) {
        log.info("PaginationService :: getPaginationBarNumbers :: currentPageNumber = {}, totalPageCount = {}", currentPageNumber, totalPagesCount);
        int startPageNumber = Math.max(currentPageNumber - (PAGINATION_BAR_LENGTH / 2), 0);
        int endPageNumber = Math.min(startPageNumber + PAGINATION_BAR_LENGTH - 1, totalPagesCount - 1);

        if (endPageNumber - startPageNumber != PAGINATION_BAR_LENGTH - 1) {
            startPageNumber = Math.max(endPageNumber - PAGINATION_BAR_LENGTH + 1, 0);
        }

        return IntStream.range(startPageNumber, endPageNumber + 1).boxed().collect(Collectors.toList());
    }

}
