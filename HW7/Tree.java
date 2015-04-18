import java.io.*;
public class Tree{
    public static void main(String[] args)
    {
        list(args[0]);
    }
    public static void list(String path)
    {

        
        //make sure it ends with '/', otherwise, the list is not complete
        System.out.println(path);
        if(path.charAt(path.length()-1)!='/')
        {
            path+='/';
        }
        recursiveList(path,"",true,true);
        
    }
    //if it's the last item of the list, only the current level's table sign will be displayed
    public static void recursiveList(String path,String preIdent,boolean isLast,boolean isRoot)
    {
        File dir=new File(path);
        
        String ident="";
        //if it's a file only display the name, then stop the current branch
        if(dir.isFile())
        {   if(!isRoot)
                ident=isLast==true?getLastIdent():getIdent();
            System.out.print(preIdent+ident);
            System.out.print(dir.getName()+"\n");
            return;
        }
        if(!isRoot)
            ident=isLast==true?getLastIdent():getIdent();
        System.out.print(preIdent+ident);
        System.out.print(dir.getName()+"\n");
        String[] subDirs=dir.list();
        //only recursively list it when it's a directory
        if (subDirs==null)
            return;
        for(int i=0;i<subDirs.length;i++)
        {
            boolean last=i==subDirs.length-1?true:false;
            //System.out.print(level);
            if(isRoot)
                ident=preIdent;
            else
            {
            //if the folder this file is in is the last folder in its dir, no need to have "|  " in front of it
                if(isLast==true)
                    ident=preIdent+getEmptyIdent();
                else
                    ident=preIdent+getSubIdent();
            }
            recursiveList(path+subDirs[i]+"/",ident,last,false);
        }
    }
    public static String getIdent()
    {
        return "├──";
    }
    public static String getLastIdent()
    {
        return "└──";
    }
    public static String getSubIdent()
    {
        return "│   ";
    }
    public static String getEmptyIdent()
    {
        return "    ";
    }
}

//│├ ─  ├ ─ └
