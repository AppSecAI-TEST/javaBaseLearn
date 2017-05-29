package com.learn.thread;

import lombok.Data;

/**
 * Created by xia_yu on 2017/5/29.
 */
@Data
public class Resource {
    private String name;
    private String sex;
    private Boolean flag=false;
    public synchronized void setResource(String name,String sex){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setSex(sex);
        this.setName(name);
        this.setFlag(true);
        this.notify();
    }
    public synchronized void getResource(){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+"========="+this.getSex());
        this.setFlag(false);
        this.notify();
    }
}

class Input implements Runnable{
    private Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        int x=0;
        while (true){
                if(x==0){
                    resource.setResource("Mike","Man");
                }else{
                    resource.setResource("露西","女");
                }
                x=(x+1)%2;
        }
    }
}
class Output implements Runnable{
    private Resource resource;

    public Output(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true){
            resource.getResource();
        }
    }
}

class ResourceTest{
    public static void main(String[] args){
        Resource resource=new Resource();
        Input input=new Input(resource);
        Output output=new Output(resource);
        Thread inputThread=new Thread(input);
        Thread outputThread=new Thread(output);
        inputThread.start();
        outputThread.start();
    }
}