# TransformViewPager
A dynamic-height viewpager which can transform its pages.

[![](https://jitpack.io/v/DanteAndroid/TransformViewPager.svg)](https://jitpack.io/#DanteAndroid/TransformViewPager)

## Demostration

<img src="/demo.gif" width="385" height="680" />

## Dependency
```
  implementation 'com.github.DanteAndroid:TransformViewPager:v0.1'
```

## Usage
0. Use `TransformViewPager` which extends ViewPager
1. Make your data item implement `Transformable`
2. Make your ViewPager's adapter implement `TransformableAdapter`
3. Of course set your TransformableAdapter for the TransformViewPager
