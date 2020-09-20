import React, { useState, useEffect } from 'react';
import Filters from '../../components/Filters';
import './styles.css';
import { barOptions, pieOptions } from './chart-options'
import Chart from 'react-apexcharts';
import axios from 'axios';
import { buildBarSeries, getPlatformChartData, getGenderChartData} from './helpers'

type PieChartData = {
    labels: string[];
    series: number[];
}

type BarChartData = {
    x: string;
    y: number;
}

const initialPieData = {
    labels: [],
    series: []
}

const BASE_URL = 'https://sds1-jrestevesx.herokuapp.com';

const Charts = () => {

    const [barChartData, setBarChartData] = useState<BarChartData[]>([]);
    const [platChartData, setPlatChartData] = useState<PieChartData>(initialPieData);
    const [genderChartData, setGenderChatData] = useState<PieChartData>(initialPieData);

    useEffect(() => { 
        async function getData(){
            const recordsResponse = await axios.get(`${BASE_URL}/records`);
            const gamesResponse = await axios.get(`${BASE_URL}/games`);

            const barData = buildBarSeries(gamesResponse.data, recordsResponse.data.content);
            const platData = getPlatformChartData(recordsResponse.data.content);
            const genderData = getGenderChartData(recordsResponse.data.content);

            setBarChartData(barData);
            setPlatChartData(platData);
            setGenderChatData(genderData);
            
        }
        getData();
     }, [])

    return (
        <div className="page-container">
            <Filters link="/records" linkText="VER TABELA" />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">
                        JOGOS MAIS VOTADOS
                    </h1>
                    <div className="games-container">
                        <Chart
                            options={barOptions}
                            type="bar"
                            width="900"
                            height="650"
                            series={[{ data: barChartData }]} />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title">PLATAFORMAS</h2>
                        <Chart
                            options={{ ...pieOptions, labels: platChartData?.labels }}
                            type="donut"
                            series={platChartData?.series}
                            width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title">GENEROS</h2>
                        <Chart
                            options={{ ...pieOptions, labels: genderChartData?.labels }}
                            type="donut"
                            series={genderChartData?.series}
                            width="350"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Charts;