package nl.lilianetop.springframeworkmvc.services;

import lombok.RequiredArgsConstructor;
import nl.lilianetop.springframeworkmvc.exceptions.ExceptionNotFound;
import nl.lilianetop.springframeworkmvc.mappers.BeerMapper;
import nl.lilianetop.springframeworkmvc.models.BeerDto;
import nl.lilianetop.springframeworkmvc.repositories.BeerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDto> listBeers() {
        return beerRepository.findAll().stream().map(beerMapper::beerToBeerDto).toList();
    }

    @Override
    public Optional<BeerDto> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerToBeerDto(beerRepository.findById(id).orElse(null)));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beer){
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beer)));
    }

    @Override
    public Optional<BeerDto> updateBeerById(UUID id, BeerDto beerDto) {
        AtomicReference<Optional<BeerDto>> atomicReference = new AtomicReference<>();

        beerRepository.findById(id).ifPresentOrElse(
                beer -> {
                    beer.setBeerName(beerDto.getBeerName());
                    beer.setBeerStyle(beerDto.getBeerStyle());
                    beer.setPrice(beerDto.getPrice());
                    beer.setUpc(beerDto.getUpc());

                    atomicReference.set(Optional.of(
                            beerMapper.beerToBeerDto(beerRepository.save(beer))));
                }, () -> {
                    atomicReference.set(Optional.empty());
                }
        );

        return atomicReference.get();
    }

    @Override
    public Boolean deleteById(UUID id) {
       if(beerRepository.existsById(id)){
           beerRepository.deleteById(id);
           return true;
       }
       return false;
    }

    @Override
    public void patchBeerById(UUID id, BeerDto beer) {

    }
}
