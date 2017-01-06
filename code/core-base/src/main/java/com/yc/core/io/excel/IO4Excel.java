package com.yc.core.io.excel;

/**
 * 
 * Description: 针对于Excel的IO操作
 *  
 * Created on 2017年1月5日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class IO4Excel {

//    public void exportExcel(List<String> headers, List<Map<String, Object>> dataList, OutputStream out, String pattern) {
//        // 声明一个工作薄
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        // 生成一个表格
//        HSSFSheet sheet = workbook.createSheet();
//        // 设置表格默认列宽度为15个字节
//        sheet.setDefaultColumnWidth(IODefine.DEFAULT_COLUMN_WIDTH);
//        // 生成表格头样式
//        HSSFCellStyle headerStyle = workbook.createCellStyle();
//        // 设置这些样式
//        headerStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        // 生成表格头字体
//        HSSFFont headerFont = workbook.createFont();
//        headerFont.setColor(HSSFColor.VIOLET.index);
//        headerFont.setFontHeightInPoints(IODefine.FONT_HEIGHT_IN_POINTS);
//        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//        // 把字体应用到当前的样式
//        headerStyle.setFont(headerFont);
//        // 生成普通单元格样式
//        HSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        // 生成普通单元格字体
//        HSSFFont cellFont = workbook.createFont();
//        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//        // 把字体应用到当前的样式
//        cellStyle.setFont(cellFont);
//
//        // 声明一个画图的顶级管理器
//        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//        // 定义注释的大小和位置,详见文档
////        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
//        // 设置注释内容
////        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
//        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
////        comment.setAuthor("leno");
//
//        // 产生表格标题行
//        HSSFRow row = sheet.createRow(0);
//        for (int i = 0; i < headers.size(); i++) {
//            HSSFCell cell = row.createCell(i);
//            cell.setCellStyle(headerStyle);
//            HSSFRichTextString text = new HSSFRichTextString(headers.get(i));
//            cell.setCellValue(text);
//        }
//        
//        for (Map<String, Object> data : dataList) {
//            
//        }
//
//        // 遍历集合数据，产生数据行
//        Iterator<T> it = dataset.iterator();
//        int index = 0;
//        while (it.hasNext()) {
//            index++;
//            row = sheet.createRow(index);
//            T t = (T) it.next();
//            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
//            Field[] fields = t.getClass().getDeclaredFields();
//            for (int i = 0; i < fields.length; i++) {
//                HSSFCell cell = row.createCell(i);
//                cell.setCellStyle(cellStyle);
//                Field field = fields[i];
//                String fieldName = field.getName();
//                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                try {
//                    Class tCls = t.getClass();
//                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
//                    Object value = getMethod.invoke(t, new Object[] {});
//                    // 判断值的类型后进行强制类型转换
//                    String textValue = null;
//                    // if (value instanceof Integer) {
//                    // int intValue = (Integer) value;
//                    // cell.setCellValue(intValue);
//                    // } else if (value instanceof Float) {
//                    // float fValue = (Float) value;
//                    // textValue = new HSSFRichTextString(
//                    // String.valueOf(fValue));
//                    // cell.setCellValue(textValue);
//                    // } else if (value instanceof Double) {
//                    // double dValue = (Double) value;
//                    // textValue = new HSSFRichTextString(
//                    // String.valueOf(dValue));
//                    // cell.setCellValue(textValue);
//                    // } else if (value instanceof Long) {
//                    // long longValue = (Long) value;
//                    // cell.setCellValue(longValue);
//                    // }
//                    if (value instanceof Boolean) {
//                        boolean bValue = (Boolean) value;
//                        textValue = "男";
//                        if (!bValue) {
//                            textValue = "女";
//                        }
//                    }
//                    else if (value instanceof Date) {
//                        Date date = (Date) value;
//                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//                        textValue = sdf.format(date);
//                    }
//                    else if (value instanceof byte[]) {
//                        // 有图片时，设置行高为60px;
//                        row.setHeightInPoints(60);
//                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
//                        sheet.setColumnWidth(i, (short) (35.7 * 80));
//                        // sheet.autoSizeColumn(i);
//                        byte[] bsValue = (byte[]) value;
//                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6,
//                            index);
//                        anchor.setAnchorType(2);
//                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
//                    }
//                    else {
//                        // 其它数据类型都当作字符串简单处理
//                        textValue = value.toString();
//                    }
//                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
//                    if (textValue != null) {
//                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
//                        Matcher matcher = p.matcher(textValue);
//                        if (matcher.matches()) {
//                            // 是数字当作double处理
//                            cell.setCellValue(Double.parseDouble(textValue));
//                        }
//                        else {
//                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
//                            HSSFFont font3 = workbook.createFont();
//                            font3.setColor(HSSFColor.BLUE.index);
//                            richString.applyFont(font3);
//                            cell.setCellValue(richString);
//                        }
//                    }
//                }
//                catch (SecurityException e) {
//                    e.printStackTrace();
//                }
//                catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                }
//                catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                }
//                catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    // 清理资源
//                }
//            }
//        }
//        try {
//            workbook.write(out);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
