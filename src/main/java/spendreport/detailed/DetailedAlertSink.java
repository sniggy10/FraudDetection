package spendreport.detailed;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** A sink for outputting alerts. */
public class DetailedAlertSink implements SinkFunction<DetailedAlert> {

    private static final Logger LOG = LoggerFactory.getLogger(DetailedAlertSink.class);

    public void invoke(DetailedAlert value, Context context) {
        LOG.info(value.toString());
    }
}