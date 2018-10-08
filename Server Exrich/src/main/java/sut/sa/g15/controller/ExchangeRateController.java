package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.ExchangeRate;
import sut.sa.g15.repository.ExchangeRateRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExchangeRateController {


    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    // Exchange-Rate
    @GetMapping(path = "/exchange-rate-date/{date}")
    public Collection<ExchangeRate> getExchangeRateDate(@PathVariable String date) throws ParseException {
        Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return exchangeRateRepository.findByDate(dateFormat).stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/exchange-rate-last")
    public Collection<ExchangeRate> getExchangeRatesLast() {
        return exchangeRateRepository.findByDate(new Date()).stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/exchange-rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ExchangeRate> getExchangeRate() {
        return exchangeRateRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "exchange-rate/{exrateone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRate getOneExchangeRate(@PathVariable Long exrateone) {
        return exchangeRateRepository.findById(exrateone).get();
    }

    @PutMapping(path = "exchange-rate/{id}")
    public ExchangeRate putExchangeRate(@RequestBody ExchangeRate newExchangeRate, @PathVariable Long id) {
        return exchangeRateRepository.findById(id).map(exchangeRate -> {
                    exchangeRate.setBankNotesBuying(newExchangeRate.getBankNotesBuying());
                    exchangeRate.setBankNotesSelling(newExchangeRate.getBankNotesSelling());
                    exchangeRate.setDate(newExchangeRate.getDate());
                    return exchangeRateRepository.save(exchangeRate);
                }
        ).orElseGet(() -> {
            return exchangeRateRepository.save(newExchangeRate);
        });
    }

    @PostMapping(path = "/exchange-rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRate newExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    @DeleteMapping(path = "exchange-rate/{id}")
    public void deleteExchangeRate(@PathVariable Long id) {
        exchangeRateRepository.deleteById(id);
    }

}
