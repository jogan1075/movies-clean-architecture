package pabloaraya.org.domain.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import pabloaraya.org.data.datasource.MovieDataSource;
import pabloaraya.org.data.entity.MovieEntity;
import pabloaraya.org.domain.model.MovieModel;
import pabloaraya.org.domain.repository.mapper.MovieModelToMovieEntityMapper;

public class MovieApiRepository implements MovieRepository {

    @Inject MovieDataSource movieDataSource;
    @Inject MovieModelToMovieEntityMapper movieModelToMovieEntityMapper;

    @Override
    public Observable<List<MovieModel>> getMovies() {
        return movieDataSource.getMovies().map(new Function<List<MovieEntity>, List<MovieModel>>() {
            @Override
            public List<MovieModel> apply(List<MovieEntity> movieEntities) {
                return movieModelToMovieEntityMapper.reverseMap(movieEntities);
            }
        });
    }
}