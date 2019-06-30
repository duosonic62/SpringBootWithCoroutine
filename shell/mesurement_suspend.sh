#!/bin/bash

# リクエスト数
max=100

# 計測開始
start_time=`date +%s%M`
echo $start_time

# リクエスト
for i in `seq $max`
do
    curl GET http://localhost:8080 -o /dev/null -s &
done

# 終了待ち
wait

end_time=`date +%s%M`
echo $end_time
time=$((end_time - start_time))

echo $time
