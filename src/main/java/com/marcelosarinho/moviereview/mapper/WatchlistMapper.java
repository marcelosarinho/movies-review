package com.marcelosarinho.moviereview.mapper;

import com.marcelosarinho.moviereview.dto.watchlist.WatchlistDTO;
import com.marcelosarinho.moviereview.entity.Watchlist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MovieMapper.class)
public interface WatchlistMapper {
    WatchlistDTO toWatchlistDTO(Watchlist watchlist);
//    Watchlist toWatchlistEntity(WatchlistDTO watchlistDTO);
    List<WatchlistDTO> toWatchlistDTOList(List<Watchlist> watchlists);
}
