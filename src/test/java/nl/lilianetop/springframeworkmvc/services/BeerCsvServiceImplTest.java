package nl.lilianetop.springframeworkmvc.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import nl.lilianetop.springframeworkmvc.models.BeerCSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

public class BeerCsvServiceImplTest {

  BeerCsvService beerCsvService = new BeerCsvServiceImpl();

  @Test
  void covertCSV() throws FileNotFoundException {
    File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");
    List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);
    System.out.println(recs.size());

    assertThat(recs.size()).isEqualTo(2410);
  }

}
