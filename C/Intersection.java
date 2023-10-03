package ca.objet_csv;

import ca.calculus.Cardinals_point;
import ca.calculus.Linear_regression;
import ca.calculus.Point;

import java.util.ArrayList;

public class Intersection {

    private String mNomInter;
    private int mNumeroInter;
    private Cardinals_point[] mTotal_Banque;
    private String[] mNom_Banque;
    private double mLatitude;
    private double mLongitude;
    private long[] mTotal_PeriodeB;
    private Linear_regression[] mSlope_model;
    private String[][] mPlage_Horaire;
    private boolean[] mHeure_Debut;

    //constructeur de la class intersection
    public Intersection(String nom, int NumeroInter, double longitude, double latitude){

        this.mNomInter = nom;
        this.mNumeroInter = NumeroInter;
        mNom_Banque = new String[]{"Pietons", "Autos", "Bus","Camions legers", "Camions Lourds","Velos","Camions"};
        mTotal_Banque = new Cardinals_point[]{new Cardinals_point(),new Cardinals_point(),new Cardinals_point(),new Cardinals_point(),new Cardinals_point(),new Cardinals_point(),new Cardinals_point()};
        mTotal_PeriodeB = new long[]{0,0,0,0,0,0,0};
        mPlage_Horaire =new String[][]{{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
        mHeure_Debut = new boolean[]{false,false,false,false,false,false,false};

        this.mLatitude = latitude;
        this.mLongitude = longitude;
        //use a tab because we already know the number of linear regression we need
        this.mSlope_model = new Linear_regression[]{new Linear_regression(),new Linear_regression(),new Linear_regression(),new Linear_regression(),new Linear_regression(),new Linear_regression(),new Linear_regression()};

    }
    public boolean[] getmHeure_Debut() {
        return mHeure_Debut;
    }

    public String getmNomInter() {
        return mNomInter;
    }

    public int getmNumeroInter() {
        return mNumeroInter;
    }

    public int getmNomBanqueLength(){
        return mNom_Banque.length;
    }

    public Cardinals_point[] getmTotal_Banque() {
        return mTotal_Banque;
    }

    public String[] getmNom_Banque() {
        return mNom_Banque;
    }
    public double getmLatitude() {
        return mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public ArrayList<Point> getArray_mSlope_model(int i) {
        return mSlope_model[i].get_pt();
    }

    public long[] getmTotal_PeriodeB() {
        return mTotal_PeriodeB;
    }
    public String[][] getmPlage_Horaire() {
        return mPlage_Horaire;
    }
    public void setmPlage_Horaire(String add, int i,int h) {
        this.mPlage_Horaire[i][h] = add;
    }


    public void setmTotal_Banque(int add, int i, int ptC) {
        this.mTotal_Banque[i].setmTotal(add,ptC);
    }
    public void setmHeure_Debut(boolean add, int i) {
        this.mHeure_Debut[i] = add;
    }

    public void setmTotal_PeriodeB(int add, int i) {
        this.mTotal_PeriodeB[i] = add+this.mTotal_PeriodeB[i];
    }
    public void setmSlope_model(Point pt, int i) {
        this.mSlope_model[i].set_pt(pt);
    }


    /**
     * fait le calcul du modèle pour une catégorie en particulier
     * @param i
     */
    public void calculus_linear_regressionI(int i ){
        this.mSlope_model[i].calculus_linear();
    }

    /**
     * fait le calcul pour un modèle en particulier
     * @param i
     * @param x
     * @return
     */
    public double  predict_value(int i,double x){
        //System.out.println(this.mSlope_model[i].toString());
        return this.mSlope_model[i].predict(x);
    }

    /**
     * renvoie le total d'achalandage par Intersection
     * @return
     */
    public int getmTotal_impression(){
        int result = 0;
        for (int i=0; i<this.getmNomBanqueLength();i++){
            //Total
            if (i == 1){
                result = mTotal_Banque[i].calculus_Total()*2 + result;
                //Bus
            }else if (i == 2){
                result = mTotal_Banque[i].calculus_Total()*30 + result;
            }else {
                result = mTotal_Banque[i].calculus_Total() + result;
            }
        }
        return result;
    }

    /**
     * Function to create percentage Total by Intersection
     * @return
     */
    public double[] percent_Intersection(){
        int[] trans = {0,0,0,0};
        int tot = getmTotal_impression();
        double result[] = {0,0,0,0};

        //ajoute les
        for (int j =0; j< this.getmNomBanqueLength();j++){
            int[] tab_f = this.mTotal_Banque[j].getmTotal();
            //auto
            if (j == 1){
                trans[0] += tab_f[0]*2;
                trans[1] += tab_f[1]*2;
                trans[2] += tab_f[2]*2;
                trans[3] += tab_f[3]*2;
                //Bus
            }else if (j == 2){
                trans[0] += tab_f[0]*30;
                trans[1] += tab_f[1]*30;
                trans[2] += tab_f[2]*30;
                trans[3] += tab_f[3]*30;
            }else {
                trans[0] += tab_f[0];
                trans[1] += tab_f[1];
                trans[2] += tab_f[2];
                trans[3] += tab_f[3];
            }

        }

        //calcul the percentage
        for (int i=0; i<result.length;i++){
            result[i] = (trans[i]*100.00)/tot;
        }

        return result;
    }

    /**
     * Totaux /jour/semaine/mois
     * @return
     */
    public int[] get_Totaux_Regress(){
        int[] result = {0,0,0};
        for (int i=0;i<this.getmNomBanqueLength();i++){

            //Autos
            if (i == 1){
                result[0] = (int)predict_value(i, 1440)*2 + result[0];
                result[1] = (int)predict_value(i,10080)*2+ result[1];
                result[2] = (int)predict_value(i,43800)*2+ result[2];
                //Bus
            }else if (i == 2){
                result[0] = (int)predict_value(i, 1440)*30+ result[0];
                result[1] = (int)predict_value(i,10080)*30+ result[1];
                result[2] = (int)predict_value(i,43800)*30+ result[2];
            }else {
                result[0] = (int)predict_value(i, 1440)+ result[0];
                result[1] = (int)predict_value(i,10080)+ result[1];
                result[2] = (int)predict_value(i,43800)+ result[2];
            }

        }
        return result;
    }



}
