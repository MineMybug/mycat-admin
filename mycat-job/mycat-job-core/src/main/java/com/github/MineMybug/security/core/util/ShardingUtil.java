package com.github.MineMybug.security.core.util;

/**
 * sharding vo
 * @author xuxueli 2017-07-25 21:26:38
 */
public class ShardingUtil {

    private static InheritableThreadLocal<ShardingVO> contextHolder = new InheritableThreadLocal<ShardingVO>();

    public static class ShardingVO {

        private int index;  // sharding index 当前分片序号(从0开始)，执行器集群列表中当前执行器的序号；
        private int total;  // sharding total 总分片数，执行器集群的总机器数量；

        public ShardingVO(int index, int total) {
            this.index = index;
            this.total = total;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static void setShardingVo(ShardingVO shardingVo){
        contextHolder.set(shardingVo);
    }

    public static ShardingVO getShardingVo(){
        return contextHolder.get();
    }

}
