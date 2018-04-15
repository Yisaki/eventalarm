package com.chaos.service.impl;

import com.chaos.mapper.IEventMapper;
import com.chaos.po.Event;
import com.chaos.service.IEventService;
import com.chaos.util.CommonUtil;
import com.chaos.vo.AnalysisInfo;
import com.chaos.vo.BigAuntParis;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class EventServiceImpl implements IEventService {
    @Resource
    private IEventMapper eventMapper;
    @Override
    public List<Event> listAll() {

        return eventMapper.listAll();
    }

    @Override
    public Event[] predictNextBigAunt() {
        List<Event> bigAuntEvnetList=null;
        //两次间隔
        int[] space=null;
        //持续时间
        int[] last=null;
        //准确率
        float[] scale=null;

        float spaceUp=0;
        int spaceDown=0;

        float lastUp=0;
        int lastDown=0;
        int sampleSize=space.length;
        for(int i=0;i<sampleSize;i++){
            spaceUp+=space[i]*scale[i];
            spaceDown+=space[i];

            lastUp+=last[i]*scale[i];
            spaceDown+=last[i];
        }

        return new Event[0];
    }

    @Override
    public AnalysisInfo analysis(List<Event> hisBaList) {
        List<BigAuntParis> baParisList=buildParis(hisBaList);
        AnalysisInfo analysisInfo=buildAnalysisInfo(baParisList);
        return analysisInfo;
    }

    /**
     *
     * @param hisEventList
     * @return
     */
    private List<BigAuntParis> buildParis(List<Event> hisEventList){
        int hisEventSize=hisEventList.size();
        if(hisEventSize%2!=0){
            throw new IllegalArgumentException("输入事件个数不是偶数");
        }

        List<BigAuntParis> result=new ArrayList<>();
        BigAuntParis bigAuntParis=null;
        for(int i=0;i<hisEventSize;i+=2){
            Event come=hisEventList.get(i);
            Event go=hisEventList.get(i+1);
            if(come.getEventType()==1&&go.getEventType()==2){
                bigAuntParis=new BigAuntParis(come,go);
                result.add(bigAuntParis);
            }else{
                System.out.println("error ");
            }
        }
        return result;
    }

    /**
     * 根据大姨妈对 计算 平均时间
     * @param baParisList
     * @return
     */
    private AnalysisInfo buildAnalysisInfo(List<BigAuntParis> baParisList){
        int sumLastDay=0;
        int sumGapDay=0;
        int baPairsSize=baParisList.size();

        for(int i=0;i<baPairsSize;i++){
            //持续时间
            BigAuntParis bigAuntParis=baParisList.get(i);
            sumLastDay+=bigAuntParis.getLastDays();
            System.out.println(bigAuntParis.getLastDays());

            //间隔时间
            if(i<baPairsSize-1){
                BigAuntParis nextBigAuntParis=baParisList.get(i+1);
                int gapDay= CommonUtil.getSubDay(bigAuntParis.getBigAuntGo().getEventTime(),nextBigAuntParis.getBigAuntCome().getEventTime());
                sumGapDay+=gapDay;
                System.out.println(gapDay);
            }

        }

        //平均大姨妈持续时间
        int avgLastDay=Math.round(sumLastDay/baPairsSize);
        //间隔时间
        int avgGapDay=Math.round(sumGapDay/(baPairsSize-1));

        AnalysisInfo analysisInfo=new AnalysisInfo();

        analysisInfo.setAvgGapDay(avgGapDay);
        analysisInfo.setAvgLastDay(avgLastDay);

        //根据平均值计算下次发生时间
        Date lastEnd=baParisList.get(baPairsSize-1).getBigAuntGo().getEventTime();
        Calendar lastEndCal=Calendar.getInstance();
        lastEndCal.setTime(lastEnd);
        lastEndCal.add(Calendar.DAY_OF_MONTH,avgGapDay);
        analysisInfo.setNextCome(lastEndCal.getTime());

        lastEndCal.add(Calendar.DAY_OF_MONTH,avgLastDay);
        analysisInfo.setNextGo(lastEndCal.getTime());

        return analysisInfo;
    }

    @Transactional(readOnly = false)
    @Override
    public int saveNext(BigAuntParis bigAuntParis) {

        eventMapper.save(bigAuntParis.getBigAuntCome());
        eventMapper.save(bigAuntParis.getBigAuntGo());

        return 0;
    }
}
