package nextstep.subway.applicaion.pathfinder;


import nextstep.subway.domain.Line;
import nextstep.subway.domain.Path;
import nextstep.subway.domain.PathType;
import nextstep.subway.domain.Station;
import nextstep.subway.domain.subwaymap.DurationSubwayMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurationPathFinder implements PathFinder {

    @Override
    public PathFinder findPathFinder(final PathType pathType) {
        if (pathType == PathType.DURATION) {
            return this;
        }

        return null;
    }

    @Override
    public Path findPath(final List<Line> lines, final Station source, final Station target) {
        return new DurationSubwayMap(lines).findPath(source, target);
    }

}
