package ch.hslu.ad.sw01.e0;

import java.util.Objects;

public final class Allokation implements Comparable<Allokation>{
    private final long address;
    private final long size;

    public Allokation(long address, long size) {
        this.address = address;
        this.size = size;
    }

    public long getAddress() {
        return address;
    }

    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allokation that = (Allokation) o;
        return address == that.address && size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, size);
    }

    @Override
    public int compareTo(Allokation other) {
        if(other.address < this.address){
            return 1;
        } else if (other.address == this.address){
            return 0;
        } else {
            return -1;
        }
    }
}
