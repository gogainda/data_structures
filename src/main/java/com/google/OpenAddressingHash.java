package com.google;

import java.util.Arrays;

public class OpenAddressingHash {
    int M = 8;
    int n = 0;
    String[] values = new String[M];
    Integer[] keys = new Integer[M];

    public void add(int key, String v) {
        if ((n * 1.0 / M) > 0.5) {
            rehash();
        }
        int i = 0;

        while(values[hash(key, i)] != null) {
            i++;
        }

        assignToEmpty(key, v, i);

        System.out.println("perms" + i);
    }

    private void rehash() {
        System.out.println("rehashing");
        M *=2;
        n = 0;
        String[] tmpValues = Arrays.copyOf(values, values.length);
        Integer[] tmpKeys = Arrays.copyOf(keys, keys.length);
        values = new String[M];
        keys = new Integer[M];
        for(int i = 0; i < tmpValues.length; i++) {
            if (tmpValues[i] != null) {
                System.out.println("rehashing" + tmpKeys[i] +  tmpValues[i]);
                add(tmpKeys[i], tmpValues[i]);
            }

        }
    }

    private void assignToEmpty(int key, String v, int i) {
        values[hash(key, i)] = v;
        keys[hash(key, i)] = key;
        n++;
    }

    public int hash(int key, int i) {
        int prime = nextPrime(M);

        return (hashInteger(key, prime) + i * oddHash(key, prime)) % M;

    }

    private int oddHash(int key, int prime) {

        return hashInteger(key, prime) | 1;
    }

    private int hashInteger(int key, int prime) {

        int a = prime - 2;
        int b = prime - 3;
        return ((a * key + b) % prime ) % M;
    }

    public static int nextPrime(int n) {

        boolean isPrime;
        n++;
        while (true) {
            int sqrt = (int) Math.sqrt(n);
            isPrime = true;
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) isPrime = false;
            }
            if (isPrime)
                return n;
            else {
                n++;
            }
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenAddressingHash that = (OpenAddressingHash) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    public String get(int key) {
        int i = 0;

        while(keys[hash(key, i)] != null) {
            if (values[hash(key, i)].equals("*")) {
                i++;
                continue;
            }
            if (keys[hash(key, i)] != key) {
                i++;
            } else {
                return values[hash(key, i)];
            }

        }
        return values[hash(key, i)];
    }

    public void remove(int key) {
        int i = 0;

        while(values[hash(key, i)] == null) {
            i++;
        }
    System.out.println("found" + i);

        values[hash(key, i)] = "*";
        n--;
    }
}
