package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.watchlist.WatchlistDTO;
import com.marcelosarinho.moviereview.entity.Watchlist;
import com.marcelosarinho.moviereview.entity.enums.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = MovieMapper.class)
public interface WatchlistMapper {
    WatchlistDTO toWatchlistDTO(Watchlist watchlist);
    List<WatchlistDTO> toWatchlistDTOList(List<Watchlist> watchlists);

    default Interest map(Integer interest) {
        if (interest == null) return null;

        return Interest.valueOf(interest);
    }
}
