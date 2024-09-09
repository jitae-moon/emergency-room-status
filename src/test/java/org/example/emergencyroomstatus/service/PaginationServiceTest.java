package org.example.emergencyroomstatus.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("페이지네이션 서비스 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = PaginationService.class)
class PaginationServiceTest {

    PaginationService sut;

    @Autowired
    public PaginationServiceTest(PaginationService sut) {
        this.sut = sut;
    }

    @DisplayName("총 페이지 수가 5 이상일 때 테스트")
    @MethodSource("totalPagesGreaterOrEqualToBarLength")
    @ParameterizedTest
    void givenTotalPagesCountBiggerThanOne_whenCalculatingPageNumbers_thenReturnsPaginationBarNumbers(int currentPageNumber, int totalPagesCount, List<Integer> expected) {
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPagesCount);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> totalPagesGreaterOrEqualToBarLength() {

        return Stream.of(
                Arguments.of(0, 10, List.of(0, 1, 2, 3, 4)),
                Arguments.of(1, 10, List.of(0, 1, 2, 3, 4)),
                Arguments.of(2, 10, List.of(0, 1, 2, 3, 4)),
                Arguments.of(3, 10, List.of(1, 2, 3, 4, 5)),
                Arguments.of(4, 10, List.of(2, 3, 4, 5, 6)),
                Arguments.of(5, 10, List.of(3, 4, 5, 6, 7)),
                Arguments.of(6, 10, List.of(4, 5, 6, 7, 8)),
                Arguments.of(7, 10, List.of(5, 6, 7, 8, 9)),
                Arguments.of(8, 10, List.of(5, 6, 7, 8, 9)),
                Arguments.of(9, 10, List.of(5, 6, 7, 8, 9))
        );
    }

    @DisplayName("총 페이지 수가 5 미만인 경우 테스트")
    @MethodSource("totalPagesLessThanBarLength")
    @ParameterizedTest
    void givenTotalPagesLessThanBarLength_whenCalculatingPaginationBarNumbers_thenReturnsBarNumbersAsList(int currentPageNumber, int totalPagesCount, List<Integer> expected) {
        List<Integer> actual = sut.getPaginationBarNumbers(currentPageNumber, totalPagesCount);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> totalPagesLessThanBarLength() {

        return Stream.of(
                Arguments.of(0, 3, List.of(0, 1, 2)),
                Arguments.of(1, 3, List.of(0, 1, 2))
        );
    }

}