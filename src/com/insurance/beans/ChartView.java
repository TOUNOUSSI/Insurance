/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insurance.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;

@ManagedBean(name = "chartViewBean")
public class ChartView implements Serializable {

    private PieChartModel pieModel;
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private LineChartModel zoomModel;
    private CartesianChartModel combinedModel;
    private CartesianChartModel fillToZero;
    private LineChartModel areaModel;
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private DonutChartModel donutModel1;
    private DonutChartModel donutModel2;
    private MeterGaugeChartModel meterGaugeModel1;
    private MeterGaugeChartModel meterGaugeModel2;
    private BubbleChartModel bubbleModel1;
    private BubbleChartModel bubbleModel2;
    private OhlcChartModel ohlcModel;
    private OhlcChartModel ohlcModel2;
    private PieChartModel livePieModel;
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel multiAxisModel;
    private LineChartModel dateModel;
    private String[] sinistres = {};
    private String[] contrats = {};

    @PostConstruct
    public void init() {
        createLineModel();
        createPieModel();
    }

    private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
         
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);
         
        pieModel.setData(data);
    }
    public ChartView() {

        this.sinistres = new SinistreBean().getSinistreNumberPerMonth();
        this.contrats = new ContratBean().getContratNumberPerMonth();

    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    public LineChartModel getZoomModel() {
        return zoomModel;
    }

    public CartesianChartModel getCombinedModel() {
        return combinedModel;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
    }

    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }

    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }

    public DonutChartModel getDonutModel2() {
        return donutModel2;
    }

    public CartesianChartModel getFillToZero() {
        return fillToZero;
    }

    public BubbleChartModel getBubbleModel1() {
        return bubbleModel1;
    }

    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }

    public OhlcChartModel getOhlcModel() {
        return ohlcModel;
    }

    public OhlcChartModel getOhlcModel2() {
        return ohlcModel2;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }

    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }

    public LineChartModel getDateModel() {
        return dateModel;
    }

    public void createLineModel() {
        lineModel1 = new LineChartModel();
        ChartData data = new ChartData();
        List<String> sinistresLabels = new ArrayList<>();
        List<String> contratsLabels = new ArrayList<>();
        LineChartDataSet sinistresDATASET = new LineChartDataSet();
        LineChartDataSet contratsDATASET = new LineChartDataSet();
        List<Number> sinistresValues = new ArrayList<>();
        List<Number> contratsValues = new ArrayList<>();
        String[] months = new String[]{"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};

        if (this.sinistres.length > 2) {
            for (int i = 0; i < this.sinistres.length; i++) {
                sinistresValues.add(Integer.parseInt(this.sinistres[i]));
                contratsValues.add(Integer.parseInt(this.contrats[i]));
                sinistresLabels.add(months[i]);
                contratsLabels.add(months[i]);
            }
        }
        sinistresDATASET.setData(sinistresValues);
        sinistresDATASET.setFill(false);
        sinistresDATASET.setLabel("Sinistres");
        sinistresDATASET.setBorderColor("rgb(75, 192, 192)");
        sinistresDATASET.setLineTension(0.1);

        contratsDATASET.setData(contratsValues);
        contratsDATASET.setFill(false);
        contratsDATASET.setLabel("Contrats");
        contratsDATASET.setBorderColor("rgb(162, 72, 72)");
        contratsDATASET.setLineTension(0.1);

        data.addChartDataSet(sinistresDATASET);
        data.setLabels(sinistresLabels);

        data.addChartDataSet(contratsDATASET);
        data.setLabels(contratsLabels);

        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Nombre de sinistre par mois");
        options.setTitle(title);

        lineModel1.setOptions(options);
        lineModel1.setData(data);
        lineModel1.setData(data);
    }
}
