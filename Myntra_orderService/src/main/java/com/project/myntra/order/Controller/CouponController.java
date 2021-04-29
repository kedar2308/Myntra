package com.project.myntra.order.Controller;

import com.project.myntra.order.Entity.Coupon;
import com.project.myntra.order.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() { return couponService.getAllCoupons(); }

    @PostMapping("/coupon")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @PutMapping("/coupon")
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/coupon/{couponId}")
    public void deleteCoupon(@PathVariable("couponId") Long couponId) {
        couponService.deleteCoupon(couponId);
    }
}
