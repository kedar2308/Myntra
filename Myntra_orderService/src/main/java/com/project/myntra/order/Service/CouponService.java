package com.project.myntra.order.Service;

import com.project.myntra.order.Entity.Coupon;
import com.project.myntra.order.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public boolean isValid(String couponCode) {
        if(couponRepository.findByCouponCode(couponCode).isPresent()) return true;
        return false;
    }

    public Optional<Coupon> getCoupon(String couponCode) {
        return couponRepository.findByCouponCode(couponCode);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Coupon updateCoupon(Coupon coupon) {
        Optional<Coupon> coupon1 = couponRepository.findById(coupon.getId());
        if(coupon1.isPresent()) {
            coupon1.get().setCouponCode(coupon.getCouponCode());
            coupon1.get().setDiscount(coupon.getDiscount());
            return couponRepository.save(coupon);
        }
        return createCoupon(coupon);
    }

    public void deleteCoupon(Long couponId) {
        Optional<Coupon> coupon = couponRepository.findById(couponId);
        if(coupon.isPresent()) couponRepository.delete(coupon.get());
    }
}
