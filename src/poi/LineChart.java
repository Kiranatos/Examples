/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package poi;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Line chart example.
 */
public class LineChart {

    public static void main(String[] args) throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("linechart");
        final int NUM_OF_ROWS = 3;
        final int NUM_OF_COLUMNS = 10;

        // Create a row and put some cells in it. Rows are 0 based.
        Row row;
        Cell cell;
        for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
            row = sheet.createRow((short) rowIndex);
            for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
                cell = row.createCell((short) colIndex);
                cell.setCellValue(colIndex * (rowIndex + 1));
            }
        }
        
        // Drawing - интерфейс
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
        /**
         * Anchor-ом размечаем область
         * https://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/Drawing.html
         * dx1, dy1, dx2, dy2 - хрен его знает, что они делают
         * 
         * ClientAnchor createAnchor(int dx1, int dy1, int dx2, int dy2, int col1, int row1, int col2, int row2)
         * dx1 - the x coordinate in EMU within the first cell.
         * dy1 - the y coordinate in EMU within the first cell.
         * dx2 - the x coordinate in EMU within the second cell.
         * dy2 - the y coordinate in EMU within the second cell.
         * col1 - the column (0 based) of the first cell.
         * row1 - the row (0 based) of the first cell.
         * col2 - the column (0 based) of the second cell.
         * row2 - the row (0 based) of the second cell.
         */

        Chart chart = drawing.createChart(anchor); //Создаем график и связывем его с областью Anchor и с Drawing
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.TOP_RIGHT); //Позиция легенды на графике - (Ряд 1, Ряд 2, ...)

        //Объект для хранения данных графика:
        LineChartData data = chart.getChartDataFactory().createLineChartData();

        // Use a category axis for the bottom axis.
        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM); //Ось х ???
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT); //Ось у ???
        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO); //пересечь в нуле ???

        //Где находятся данные в листе
        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS - 1)); //x1 x2 y1 y2
        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 0, NUM_OF_COLUMNS - 1));
        ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(2, 2, 0, NUM_OF_COLUMNS - 1));
        
        //Добавляем эти данные в объект LineChartData data
        data.addSeries(xs, ys1);
        data.addSeries(xs, ys2);

        // передаем данные и оси
        chart.plot(data, bottomAxis, leftAxis); // plot - участок, диаграмма, график

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("ooxml-line-chart.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}
