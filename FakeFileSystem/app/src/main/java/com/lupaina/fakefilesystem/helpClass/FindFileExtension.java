package com.lupaina.fakefilesystem.helpClass;

import com.lupaina.fakefilesystem.R;

public class FindFileExtension {


    /**
     * @param fileName file name with extension
     * @return an image that matches the extension
     */
    public static int getFileIcon(String fileName) {
        String[] splitName = fileName.split("\\.");
        if (splitName.length < 2)
            return R.drawable.ic_undefound;

        String extension = splitName[1];

        switch (extension) {
            case "xlsx":
                return R.drawable.ic_xlsx;

            case "pdf":
                return R.drawable.ic_pdf;

            case "sh":
                return R.drawable.ic_sh;

            case "docx":
                return R.drawable.ic_docx;

            case "txt":
                return R.drawable.ic_txt;

            case "dat":
                return R.drawable.ic_dat;

            default:
                return R.drawable.ic_undefound;

        }

    }
}
