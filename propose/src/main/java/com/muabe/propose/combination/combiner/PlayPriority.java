package com.muabe.propose.combination.combiner;


import com.muabe.propose.combination.Priority;

public class PlayPriority implements Priority<Float> {
    private int priority = 0;
    private float startRatio; //시작 ratio
    private float endRatio; //종료 ratio
    private float ratioRange; //시작과 종료를 뺀 ratio 범위

    void setRatioRange(float minRatio, float maxRatio){
        this.startRatio = minRatio;
        this.endRatio = maxRatio;
        this.ratioRange = maxRatio - minRatio;
    }

    float getPlayRatio(float ratio){
        float realRatio = (ratio - startRatio)/ratioRange;
        if(realRatio <= ratioRange){
            return realRatio;
        }
        return -1f;
    }

    public float getStartRatio(){
        return startRatio;
    }

    public float getEndRatio(){
        return endRatio;
    }

    @Override
    public float compare(Float ratio) {
//        this.point = param;
//        float ratio = point.getRatio();
        if (startRatio < ratio && ratio <= endRatio) {
            return 1f;
        }
        return 0f;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }
}