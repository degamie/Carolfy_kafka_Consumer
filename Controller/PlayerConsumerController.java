package com.kafka.Carofly.Controller;

import com.kafka.Carofly.dto.PlayerConsumerdto;
import com.kafka.Carofly.dto.PlayerEventRecord;
import com.kafka.Carofly.repository.PlayerEventRepository;
import com.kafka.Carofly.service.PlayerConsumer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player-consumer")
public class PlayerConsumerController {

    private final PlayerConsumer playerConsumer;
    private final PlayerEventRepository playerEventRepository;

    public PlayerConsumerController(PlayerConsumer playerConsumer, PlayerEventRepository playerEventRepository) {
        this.playerConsumer = playerConsumer;
        this.playerEventRepository = playerEventRepository;
    }

    /**
     * Retrieve paginated player events with sorting.
     * Example: GET /player-consumer/playerevents?page=0&size=10&sort=timestamp,desc
     */
    @Cacheable("player-cache")
    @GetMapping("/playerevents")
    public Page<PlayerEventRecord> getPlayerEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,desc") String sort) {

        String[] sortParams = sort.split(",");
        String property = sortParams[0].trim();
        Sort.Direction direction = (sortParams.length > 1 && sortParams[1].trim().equalsIgnoreCase("asc"))
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, property));
        return playerEventRepository.findAll(pageable);
    }

    /**
     * Retrieve player information by ID.
     * Example: GET /player-consumer/playerid?playerconsumerid=P12345
     */
    @GetMapping("/playerid")
    public String consumePlayerId(@RequestParam("playerconsumerid") String playerConsumerId) {
        String output = String.valueOf(ResponseEntity.ok(playerConsumerId));
        return output;
    }

    /**
     * Ingest/process player payload via HTTP.
     * Example: POST /player-consumer/message?msg=join
     */
    @PostMapping("/message")
    public ResponseEntity<String> processPlayerMessage(
            @RequestBody PlayerConsumerdto playerConsumerDto,
            @RequestParam(value = "msg", required = false, defaultValue = "") String msg) {

        // Delegates to service logic without exposing Kafka internals (Ack) to HTTP callers
        String response = playerConsumer.processDirectPlayerMessage(msg, playerConsumerDto);
        return ResponseEntity.ok(response);
    }
}